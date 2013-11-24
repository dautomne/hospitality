package com.toxeek.hospitality.data.model.common;


import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class DateRangeTest
{
    @Test
    public void testIteratorOverOneWeekWithoutExlusion()
        throws Exception
    {

        DateRange dr = new DateRange( LocalDate.now(), LocalDate.now().plusWeeks( 1 ) );
        int i = 0;
        LocalDate last = null;
        for ( LocalDate date : dr )
        {
            assertEquals( date, LocalDate.now().plusDays( i++ ) );
            last = date;
        }
        assertEquals( last, LocalDate.now().plusWeeks( 1 ) );//check que la endDate est incluse
    }

    @Test
    public void testIteratorOverOneWeekWithMondayExlusion()
        throws Exception
    {
        LocalDate startDate = LocalDate.parse( "2013-11-11" ); //un Lundi
        DateRange dr = new DateRange( startDate, startDate.plusWeeks( 1 ), false, true, true, true, true, true, true );
        int i = 1;
        LocalDate last = null;
        for ( LocalDate date : dr )
        {
            assertEquals( date, startDate.plusDays( i++ ) );
            last = date;
        }
        assertEquals( last, startDate.plusDays( 6 ) );
    }

    @Test
    public void testIteratorOneDay()
        throws Exception
    {
        LocalDate startDate = LocalDate.now();
        DateRange dr = new DateRange( startDate, startDate );
        int i = 0;
        LocalDate last = null;
        for ( LocalDate date : dr )
        {
            assertEquals( date, startDate.plusDays( i++ ) );
            last = date;
        }
        assertEquals( last, startDate );
    }

    @Test
    public void testIteratorOneDayExcluded()
        throws Exception
    {
        LocalDate startDate = LocalDate.parse( "2013-11-11" ); //un Lundi
        DateRange dr = new DateRange( startDate, startDate, false, true, true, true, true, true, true );
        Iterator<LocalDate> it = dr.iterator();
        assertFalse( it.hasNext() );
    }

    @Test
    public void testConstructors()
        throws Exception
    {
        LocalDate startDate = LocalDate.now();
        DateRange dr1 = new DateRange( startDate, startDate.plusDays( 7 ) );
        DateRange dr2 = new DateRange( startDate, Days.days( 7 ) );
        assertEquals( dr1, dr2 );
    }
}
