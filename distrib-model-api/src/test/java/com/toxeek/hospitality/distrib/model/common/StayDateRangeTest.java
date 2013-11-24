package com.toxeek.hospitality.distrib.model.common;


import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StayDateRangeTest
{
    @Test
    public void testIteratorOverOneWeek()
        throws Exception
    {

        StayDateRange dr = new StayDateRange( LocalDate.now(), LocalDate.now().plusWeeks( 1 ) );
        int i = 0;
        LocalDate last = null;
        for ( LocalDate date : dr )
        {
            assertEquals( date, LocalDate.now().plusDays( i++ ) );
            last = date;
        }
        assertEquals( last, LocalDate.now().plusWeeks( 1 ).minusDays( 1 ) );//check que la endDate est exclue
    }

    @Test
    public void testConstructors()
        throws Exception
    {
        LocalDate startDate = LocalDate.now();
        StayDateRange dr1 = new StayDateRange( startDate, startDate.plusDays( 7 ) );
        StayDateRange dr2 = new StayDateRange( startDate, Days.days( 7 ) );
        assertEquals( dr1, dr2 );
    }
}
