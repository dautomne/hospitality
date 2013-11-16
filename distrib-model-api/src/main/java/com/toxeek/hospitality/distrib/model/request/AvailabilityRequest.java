package com.toxeek.hospitality.distrib.model.request;

import com.google.common.base.Objects;
import com.toxeek.hospitality.distrib.model.common.GuestCount;
import com.toxeek.hospitality.distrib.model.common.StayDateRange;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Collections;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Class description
 *
 * @author <a href="mailto:dautomne@toxeek.com">Dris Automne</a>
 */
public class AvailabilityRequest
{
    @Nonnull
    private final StayDateRange stayDateRange;

    /**
     * Collection of requested properties
     */
    @Nonnull
    private final Collection<String> hotelCodes;

    /**
     * Collection of requested rate plans.
     */
    @Nonnull
    private final Collection<String> ratePlanCodes;

    /**
     * The number of guests and ages of the guests.
     */
    @Nonnull
    private final GuestCount guestCount;

    /**
     * A boolean flag that indicates the response message should include availability and rates that do not span the complete stay.
     */
    private boolean allowPartialAvail;

    /**
     * A boolean flag that indicates the response should include ONLY those rates that are available in the date range specified, or whether rates that are NOT available should be shown. True returns only available rates; False returns all rates.
     */
    private boolean availRatesOnly = true;

    /**
     * Collection of requested room types.
     */
    private Collection<String> roomTypeCodes;

    public AvailabilityRequest( @Nonnull StayDateRange stayDateRange, @Nonnull Collection<String> hotelCodes,
                                @Nonnull Collection<String> ratePlanCodes, @Nonnull GuestCount guestCount )
    {
        checkNotNull( stayDateRange );
        checkNotNull( hotelCodes );
        checkNotNull( ratePlanCodes );
        checkNotNull( guestCount );
        checkArgument( hotelCodes.size() > 0, "At least one hotel code is required" );
        checkArgument( ratePlanCodes.size() > 0, "At least one rateplan code is required" );

        this.stayDateRange = stayDateRange;
        this.hotelCodes = hotelCodes;
        this.ratePlanCodes = ratePlanCodes;
        this.guestCount = guestCount;
    }

    @Nonnull
    public StayDateRange getStayDateRange()
    {
        return stayDateRange;
    }

    @Nonnull
    public Collection<String> getHotelCodes()
    {
        return hotelCodes;
    }

    public boolean isAllowPartialAvail()
    {
        return allowPartialAvail;
    }

    public void setAllowPartialAvail( boolean allowPartialAvail )
    {
        this.allowPartialAvail = allowPartialAvail;
    }

    public boolean isAvailRatesOnly()
    {
        return availRatesOnly;
    }

    public void setAvailRatesOnly( boolean availRatesOnly )
    {
        this.availRatesOnly = availRatesOnly;
    }

    @Nonnull
    public Collection<String> getRatePlanCodes()
    {
        return ratePlanCodes;
    }

    @Nonnull
    public Collection<String> getRoomTypeCodes()
    {
        return roomTypeCodes == null ? Collections.<String>emptyList() : roomTypeCodes;
    }

    public void setRoomTypeCodes( Collection<String> roomTypeCodes )
    {
        this.roomTypeCodes = roomTypeCodes;
    }

    @Nonnull
    public GuestCount getGuestCount()
    {
        return guestCount;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode( stayDateRange, hotelCodes, allowPartialAvail, availRatesOnly, ratePlanCodes,
                                 roomTypeCodes, guestCount );
    }

    @Override
    public boolean equals( @Nullable Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null || getClass() != obj.getClass() )
        {
            return false;
        }
        final AvailabilityRequest other = (AvailabilityRequest) obj;
        return Objects.equal( this.stayDateRange, other.stayDateRange ) && Objects.equal( this.hotelCodes,
                                                                                          other.hotelCodes )
            && Objects.equal( this.allowPartialAvail, other.allowPartialAvail ) && Objects.equal( this.availRatesOnly,
                                                                                                  other.availRatesOnly )
            && Objects.equal( this.ratePlanCodes, other.ratePlanCodes ) && Objects.equal( this.roomTypeCodes,
                                                                                          other.roomTypeCodes )
            && Objects.equal( this.guestCount, other.guestCount );
    }

    @Override
    public String toString()
    {
        return Objects.toStringHelper( this ).add( "stayDateRange", stayDateRange ).add( "hotelCodes", hotelCodes ).add(
            "allowPartialAvail", allowPartialAvail ).add( "availRatesOnly", availRatesOnly ).add( "ratePlanCodes",
                                                                                                  ratePlanCodes ).add(
            "roomTypeCodes", roomTypeCodes ).add( "guestCount", guestCount ).toString();
    }
}
