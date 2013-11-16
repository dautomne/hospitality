package com.toxeek.hospitality.data.listener.avail;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.toxeek.hospitality.data.model.listener.NotifListener;
import com.toxeek.hospitality.data.model.request.AvailNotifRequest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/**
 * Class description
 *
 * @author <a href="mailto:dautomne@toxeek.com">Dris Automne</a>
 */
public class AvailNotifRequestLogger
    extends NotifListener<AvailNotifRequest>
{
    @Override
    public ListenableFuture<Void> run( final AvailNotifRequest notifRequest, ExecutorService executorService )
    {
        ListeningExecutorService executor = MoreExecutors.listeningDecorator( executorService );
        return executor.submit( new Callable<Void>()
        {
            @Override
            public Void call()
                throws Exception
            {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        } );
    }
}
