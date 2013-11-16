package com.toxeek.hospitality.data.model.request.bookingrule;

import com.toxeek.hospitality.data.model.common.DateRange;
import com.toxeek.hospitality.data.model.request.NotifRequest;
import org.joda.time.DateTime;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

/**
 * Class description
 *
 * @author <a href="mailto:dautomne@toxeek.com">Dris Automne</a>
 */
public abstract class BookingRuleNotifRequest
    extends NotifRequest
{
    @Nullable
    private final Integer minStay;

    @Nullable
    private final Integer maxStay;

    @Nullable
    private final Boolean closeToArrival;

    @Nullable
    private final Integer booperRelativeStart;

    @Nullable
    private final Integer booperRelativeEnd;

    @Nullable
    private final DateTime booperAbsoluteStartDate;

    @Nullable
    private final DateTime booperAbsoluteEndDate;

    public BookingRuleNotifRequest( @Nonnull String hotelCode, @Nonnull Collection<String> ratePlans,
                                    @Nonnull Collection<String> roomTypes, @Nonnull DateRange dateRange,
                                    @Nullable Integer minStay, @Nullable Integer maxStay,
                                    @Nullable Boolean closeToArrival, @Nullable Integer booperRelativeStart,
                                    @Nullable Integer booperRelativeEnd, @Nullable DateTime booperAbsoluteStartDate,
                                    @Nullable DateTime booperAbsoluteEndDate )
    {
        super( hotelCode, ratePlans, roomTypes, dateRange );
        this.minStay = minStay;
        this.maxStay = maxStay;
        this.closeToArrival = closeToArrival;
        this.booperRelativeStart = booperRelativeStart;
        this.booperRelativeEnd = booperRelativeEnd;
        this.booperAbsoluteStartDate = booperAbsoluteStartDate;
        this.booperAbsoluteEndDate = booperAbsoluteEndDate;
    }

    @Nullable
    public Integer getMinStay()
    {
        return minStay;
    }

    @Nullable
    public Integer getMaxStay()
    {
        return maxStay;
    }

    @Nullable
    public Boolean getCloseToArrival()
    {
        return closeToArrival;
    }

    @Nullable
    public Integer getBooperRelativeStart()
    {
        return booperRelativeStart;
    }

    @Nullable
    public Integer getBooperRelativeEnd()
    {
        return booperRelativeEnd;
    }

    @Nullable
    public DateTime getBooperAbsoluteStartDate()
    {
        return booperAbsoluteStartDate;
    }

    @Nullable
    public DateTime getBooperAbsoluteEndDate()
    {
        return booperAbsoluteEndDate;
    }
}
