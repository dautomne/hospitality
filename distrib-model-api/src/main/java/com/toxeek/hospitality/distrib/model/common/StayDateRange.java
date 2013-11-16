package com.toxeek.hospitality.distrib.model.common;

import com.toxeek.hospitality.data.model.common.DateRange;
import org.joda.time.Days;
import org.joda.time.LocalDate;

import javax.annotation.Nonnull;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Range of dates of stay for Availability Request.
 * The endDate is the checkout Date, iterator excludes it.
 * endDate is strictly after startDate
 *
 * @author <a href="mailto:dautomne@toxeek.com">Dris Automne</a>
 */
public class StayDateRange
    extends DateRange
{
    public StayDateRange( @Nonnull LocalDate startDate, @Nonnull LocalDate endDate )
    {
        super( startDate, endDate );
        checkArgument( endDate.isAfter( startDate ), "endDate must be after startDate" );
    }

    public StayDateRange( @Nonnull LocalDate startDate, @Nonnull Days days )
    {
        super( startDate, days );
        checkArgument( days.isGreaterThan( Days.ZERO ), "days must greater than 0" );
    }

    public Iterator<LocalDate> iterator()
    {
        return new StayDateRangeIterator( startDate, endDate );
    }

    private static class StayDateRangeIterator
        implements Iterator<LocalDate>
    {
        private final LocalDate end;

        private LocalDate current;

        private StayDateRangeIterator( LocalDate start, LocalDate end )
        {
            this.current = start;
            this.end = end;
        }

        public boolean hasNext()
        {
            return current != null;
        }

        public LocalDate next()
        {
            if ( current == null )
            {
                throw new NoSuchElementException();
            }
            LocalDate ret = current;
            current = current.plusDays( 1 );
            if ( current.compareTo( end ) >= 0 )  //iterator excludes endDate
            {
                current = null;
            }
            return ret;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
}
