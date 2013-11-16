package com.toxeek.hospitality.data.services;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import com.toxeek.hospitality.data.model.request.AvailNotifRequest;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class description
 *
 * @author <a href="mailto:dautomne@toxeek.com">Dris Automne</a>
 */
public class AvailNotifService
{
    void update( AvailNotifRequest availNotifRequest, Collection<AvailNotifListener> listeners )
    {

        ExecutorService executorService = Executors.newFixedThreadPool( listeners.size() );
        List<ListenableFuture<Void>> tasks = Lists.newArrayList();
        for ( AvailNotifListener listener : listeners )
        {
            tasks.add( listener.run( availNotifRequest, executorService ) );
        }
        executorService.shutdown();
    }
}
