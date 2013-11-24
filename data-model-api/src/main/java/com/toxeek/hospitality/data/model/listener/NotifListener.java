package com.toxeek.hospitality.data.model.listener;

import com.google.common.util.concurrent.ListenableFuture;
import com.toxeek.hospitality.data.model.request.NotifRequest;

import java.util.concurrent.ExecutorService;

/**
 * Class description
 *
 * @author <a href="mailto:dautomne@toxeek.com">Dris Automne</a>
 */
public interface NotifListener<T extends NotifRequest>
{
    ListenableFuture<Void> run(  T notifRequest, ExecutorService executorService );
}
