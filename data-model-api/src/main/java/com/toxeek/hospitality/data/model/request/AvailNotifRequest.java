package com.toxeek.hospitality.data.model.request;

import com.toxeek.hospitality.data.model.common.AvailStatus;
import com.toxeek.hospitality.data.model.common.DateRange;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Class description
 *
 * @author <a href="mailto:dautomne@toxeek.com">Dris Automne</a>
 */
public class AvailNotifRequest
    extends NotifRequest
{
    @Nonnull
    private final AvailStatus availStatus;

    @Nullable
    private final Integer leftToSellValue;

    public AvailNotifRequest( @Nonnull String hotelCode, @Nonnull Collection<String> ratePlans,
                              @Nonnull Collection<String> roomTypes, @Nonnull DateRange dateRange,
                              @Nonnull AvailStatus availStatus, @Nullable Integer leftToSellValue )
    {
        super( hotelCode, ratePlans, roomTypes, dateRange );
        checkNotNull( availStatus );
        checkArgument( availStatus == AvailStatus.LEFT_TO_SELL && ( leftToSellValue == null || leftToSellValue < 0 ),
                       "Left to sell status without valid left to sell value" );
        this.availStatus = availStatus;
        this.leftToSellValue = leftToSellValue;
    }

    @Nonnull
    public AvailStatus getAvailStatus()
    {
        return availStatus;
    }

    @Nullable
    public Integer getLeftToSellValue()
    {
        return leftToSellValue;
    }
}
