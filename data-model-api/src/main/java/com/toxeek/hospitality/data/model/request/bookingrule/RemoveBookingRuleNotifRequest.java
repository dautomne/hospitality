package com.toxeek.hospitality.data.model.request.bookingrule;

import com.toxeek.hospitality.data.model.common.DateRange;
import com.toxeek.hospitality.data.model.request.NotifRequest;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * Class description
 *
 * @author <a href="mailto:dautomne@toxeek.com">Dris Automne</a>
 */
public class RemoveBookingRuleNotifRequest
    extends NotifRequest
{


    public RemoveBookingRuleNotifRequest( @Nonnull String hotelCode, @Nonnull Collection<String> ratePlans,
                                          @Nonnull Collection<String> roomTypes, @Nonnull DateRange dateRange )
    {
        super( hotelCode, ratePlans, roomTypes, dateRange );
    }


}
