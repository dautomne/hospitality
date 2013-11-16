package com.toxeek.hospitality.data.model.request;

import com.toxeek.hospitality.data.model.common.DateRange;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.Collection;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Class description
 *
 * @author <a href="mailto:dautomne@toxeek.com">Dris Automne</a>
 */
public class RateAmountNotifRequest
    extends NotifRequest
{
    @Nullable
    private BigDecimal amountAfterTax;

    @Nullable
    private BigDecimal baseAmount;

    public RateAmountNotifRequest( @Nonnull String hotelCode, @Nonnull Collection<String> ratePlans,
                                   @Nonnull Collection<String> roomTypes, @Nonnull DateRange dateRange,
                                   @Nullable BigDecimal amountAfterTax, @Nullable BigDecimal baseAmount )
    {
        super( hotelCode, ratePlans, roomTypes, dateRange );
        checkArgument( amountAfterTax != null || baseAmount != null, "At least one amount is required" );
        this.amountAfterTax = amountAfterTax;
        this.baseAmount = baseAmount;
    }

    @Nullable
    public BigDecimal getAmountAfterTax()
    {
        return amountAfterTax;
    }

    @Nullable
    public BigDecimal getBaseAmount()
    {
        return baseAmount;
    }
}
