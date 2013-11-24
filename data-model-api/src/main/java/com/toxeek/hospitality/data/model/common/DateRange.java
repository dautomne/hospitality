package com.toxeek.hospitality.data.model.common;

import com.google.common.base.Objects;
import org.joda.time.DateTimeConstants;
import org.joda.time.Days;
import org.joda.time.LocalDate;

import javax.annotation.Nonnull;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Range of dates.
 * StartDate and EndDate can be equals.
 * Specific days of week may be excluded from the range. Default : all days are included.
 *
 * @author <a href="mailto:dautomne@toxeek.com">Dris Automne</a>
 */
public class DateRange
    implements Iterable<LocalDate>
{
    @Nonnull
    protected final LocalDate startDate;

    @Nonnull
    protected final LocalDate endDate;

    @Nonnull
    private final Days days;

    private final boolean includeMonday;

    private final boolean includeTuesday;

    private final boolean includeWednesday;

    private final boolean includeThursday;

    private final boolean includeFriday;

    private final boolean includeSaturday;

    private final boolean includeSunday;

    public DateRange( @Nonnull LocalDate startDate, @Nonnull LocalDate endDate, boolean includeMonday,
                      boolean includeTuesday, boolean includeWednesday, boolean includeThursday, boolean includeFriday,
                      boolean includeSaturday, boolean includeSunday )
    {
        checkNotNull( startDate );
        checkNotNull( endDate );
        checkArgument( !endDate.isBefore( startDate ), "endDate can't be before startDate" );
        this.startDate = startDate;
        this.endDate = endDate;
        this.days = Days.daysBetween( startDate, endDate );
        this.includeMonday = includeMonday;
        this.includeTuesday = includeTuesday;
        this.includeWednesday = includeWednesday;
        this.includeThursday = includeThursday;
        this.includeFriday = includeFriday;
        this.includeSaturday = includeSaturday;
        this.includeSunday = includeSunday;
    }

    public DateRange( @Nonnull LocalDate startDate, @Nonnull Days days, boolean includeMonday, boolean includeTuesday,
                      boolean includeWednesday, boolean includeThursday, boolean includeFriday, boolean includeSaturday,
                      boolean includeSunday )
    {
        checkNotNull( startDate );
        checkNotNull( days );
        checkArgument( days.getDays() >= 0, "days must greater or equals to 0" );
        this.startDate = startDate;
        this.endDate = startDate.plusDays( days.getDays() );
        this.days = days;
        this.includeMonday = includeMonday;
        this.includeTuesday = includeTuesday;
        this.includeWednesday = includeWednesday;
        this.includeThursday = includeThursday;
        this.includeFriday = includeFriday;
        this.includeSaturday = includeSaturday;
        this.includeSunday = includeSunday;
    }

    public DateRange( @Nonnull LocalDate startDate, @Nonnull LocalDate endDate )
    {
        this( startDate, endDate, true, true, true, true, true, true, true );

    }

    public DateRange( @Nonnull LocalDate startDate, @Nonnull Days days )
    {
        this( startDate, days, true, true, true, true, true, true, true );
    }

    @Nonnull
    public LocalDate getStartDate()
    {
        return startDate;
    }

    @Nonnull
    public LocalDate getEndDate()
    {
        return endDate;
    }

    @Nonnull
    public Days getDays()
    {
        return days;
    }

    public boolean isIncludeMonday()
    {
        return includeMonday;
    }

    public boolean isIncludeTuesday()
    {
        return includeTuesday;
    }

    public boolean isIncludeWednesday()
    {
        return includeWednesday;
    }

    public boolean isIncludeThursday()
    {
        return includeThursday;
    }

    public boolean isIncludeFriday()
    {
        return includeFriday;
    }

    public boolean isIncludeSaturday()
    {
        return includeSaturday;
    }

    public boolean isIncludeSunday()
    {
        return includeSunday;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode( startDate, endDate, days, includeMonday, includeTuesday, includeWednesday,
                                 includeThursday, includeFriday, includeSaturday, includeSunday );
    }

    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null || getClass() != obj.getClass() )
        {
            return false;
        }
        final DateRange other = (DateRange) obj;
        return Objects.equal( this.startDate, other.startDate ) && Objects.equal( this.endDate, other.endDate )
            && Objects.equal( this.days, other.days ) && Objects.equal( this.includeMonday, other.includeMonday )
            && Objects.equal( this.includeTuesday, other.includeTuesday ) && Objects.equal( this.includeWednesday,
                                                                                            other.includeWednesday )
            && Objects.equal( this.includeThursday, other.includeThursday ) && Objects.equal( this.includeFriday,
                                                                                              other.includeFriday )
            && Objects.equal( this.includeSaturday, other.includeSaturday ) && Objects.equal( this.includeSunday,
                                                                                              other.includeSunday );
    }

    @Override
    public String toString()
    {
        return Objects.toStringHelper( this ).add( "startDate", startDate ).add( "endDate", endDate ).add( "days",
                                                                                                           days ).add(
            "includeMonday", includeMonday ).add( "includeTuesday", includeTuesday ).add( "includeWednesday",
                                                                                          includeWednesday ).add(
            "includeThursday", includeThursday ).add( "includeFriday", includeFriday ).add( "includeSaturday",
                                                                                            includeSaturday ).add(
            "includeSunday", includeSunday ).toString();
    }

    public Iterator<LocalDate> iterator()
    {
        return new DateRangeIterator( endDate, startDate, !includeMonday, !includeTuesday, !includeWednesday,
                                      !includeThursday, !includeFriday, !includeSaturday, !includeSunday );
    }

    private static class DateRangeIterator
        implements Iterator<LocalDate>
    {
        private final LocalDate end;

        private LocalDate current;

        private boolean excludeMonday;

        private boolean excludeTuesday;

        private boolean excludeWednesday;

        private boolean excludeThursday;

        private boolean excludeFriday;

        private boolean excludeSaturday;

        private boolean excludeSunday;

        private DateRangeIterator( LocalDate end, LocalDate current, boolean excludeMonday, boolean excludeTuesday,
                                   boolean excludeWednesday, boolean excludeThursday, boolean excludeFriday,
                                   boolean excludeSaturday, boolean excludeSunday )
        {
            this.end = end;
            this.current = findCurrent( end, current, excludeMonday, excludeTuesday, excludeWednesday, excludeThursday,
                                        excludeFriday, excludeSaturday, excludeSunday );
            this.excludeMonday = excludeMonday;
            this.excludeTuesday = excludeTuesday;
            this.excludeWednesday = excludeWednesday;
            this.excludeThursday = excludeThursday;
            this.excludeFriday = excludeFriday;
            this.excludeSaturday = excludeSaturday;
            this.excludeSunday = excludeSunday;
        }

        private LocalDate findCurrent( LocalDate end, LocalDate current, boolean excludeMonday, boolean excludeTuesday,
                                       boolean excludeWednesday, boolean excludeThursday, boolean excludeFriday,
                                       boolean excludeSaturday, boolean excludeSunday )
        {
            LocalDate ret = current;
            boolean nextFound = false;
            while ( !nextFound )
            {
                if ( ret.compareTo( end ) <= 0 && ( ret.getDayOfWeek() == DateTimeConstants.MONDAY && excludeMonday ||
                    ret.getDayOfWeek() == DateTimeConstants.TUESDAY && excludeTuesday ||
                    ret.getDayOfWeek() == DateTimeConstants.WEDNESDAY && excludeWednesday ||
                    ret.getDayOfWeek() == DateTimeConstants.THURSDAY && excludeThursday ||
                    ret.getDayOfWeek() == DateTimeConstants.FRIDAY && excludeFriday ||
                    ret.getDayOfWeek() == DateTimeConstants.SATURDAY && excludeSaturday ||
                    ret.getDayOfWeek() == DateTimeConstants.SUNDAY && excludeSunday ) )
                {
                    ret = current.plusDays( 1 );
                }
                else
                {
                    nextFound = true;
                }
            }
            if ( ret.compareTo( end ) > 0 ) //iterator includes endDate
            {
                ret = null;
            }
            return ret;
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
            current = findCurrent( end, current.plusDays( 1 ), excludeMonday, excludeTuesday, excludeWednesday,
                                   excludeThursday, excludeFriday, excludeSaturday, excludeSunday );
            return ret;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
}
