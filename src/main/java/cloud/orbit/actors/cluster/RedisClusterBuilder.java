/*
 Copyright (C) 2017 Electronic Arts Inc.  All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:

 1.  Redistributions of source code must retain the above copyright
     notice, this list of conditions and the following disclaimer.
 2.  Redistributions in binary form must reproduce the above copyright
     notice, this list of conditions and the following disclaimer in the
     documentation and/or other materials provided with the distribution.
 3.  Neither the name of Electronic Arts, Inc. ("EA") nor the names of
     its contributors may be used to endorse or promote products derived
     from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY ELECTRONIC ARTS AND ITS CONTRIBUTORS "AS IS" AND ANY
 EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL ELECTRONIC ARTS OR ITS CONTRIBUTORS BE LIABLE FOR ANY
 DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package cloud.orbit.actors.cluster;

import cloud.orbit.actors.cluster.pipeline.RedisPipelineStep;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * Created by jhegarty on 2017-01-19.
 */
public class RedisClusterBuilder
{
    private RedisClusterConfig redisClusterConfig;

    public RedisClusterBuilder() {
        redisClusterConfig = new RedisClusterConfig();
    }

    public RedisClusterBuilder nodeDirectoryUri(final String nodeDirectoryUri) {
        return this.nodeDirectoryUri(nodeDirectoryUri, false);
    }

    public RedisClusterBuilder nodeDirectoryUri(final String nodeDirectoryUri, final Boolean redisClustering) {
        redisClusterConfig.setNodeDirectoryUris(Arrays.asList(nodeDirectoryUri));
        redisClusterConfig.setNodeDirectoryClustered(redisClustering);
        return this;
    }

    public RedisClusterBuilder nodeDirectoryUris(final List<String> nodeDirectoryUris) {
        return this.nodeDirectoryUris(nodeDirectoryUris, false);
    }

    public RedisClusterBuilder nodeDirectoryUris(final List<String> nodeDirectoryUris, final Boolean redisClustering) {
        redisClusterConfig.setNodeDirectoryUris(nodeDirectoryUris);
        redisClusterConfig.setNodeDirectoryClustered(redisClustering);
        return this;
    }

    public RedisClusterBuilder actorDirectoryUri(final String actorDirectoryUri) {
        return this.actorDirectoryUri(actorDirectoryUri, false);
    }

    public RedisClusterBuilder actorDirectoryUri(final String actorDirectoryUri, final Boolean redisClustering) {
        redisClusterConfig.setActorDirectoryUris(Arrays.asList(actorDirectoryUri));
        redisClusterConfig.setActorDirectoryClustered(redisClustering);
        return this;
    }

    public RedisClusterBuilder actorDirectoryUris(final List<String> actorDirectoryUris) {
        return this.actorDirectoryUris(actorDirectoryUris, false);
    }

    public RedisClusterBuilder actorDirectoryUris(final List<String> actorDirectoryUris, final Boolean redisClustering) {
        redisClusterConfig.setActorDirectoryUris(actorDirectoryUris);
        redisClusterConfig.setActorDirectoryClustered(redisClustering);
        return this;
    }

    public RedisClusterBuilder messagingUri(final String messagingUri) {
        return this.messagingUri(messagingUri, false);
    }

    public RedisClusterBuilder messagingUri(final String messagingUri, final Boolean redisClustering) {
        redisClusterConfig.setMessagingUris(Arrays.asList(messagingUri));
        redisClusterConfig.setMessagingClustered(redisClustering);
        return this;
    }


    public RedisClusterBuilder messagingUris(final List<String> messagingUris) {
        return this.messagingUris(messagingUris, false);
    }

    public RedisClusterBuilder messagingUris(final List<String> messagingUris, final Boolean redisClustering) {
        redisClusterConfig.setMessagingUris(messagingUris);
        redisClusterConfig.setMessagingClustered(redisClustering);
        return this;
    }


    public RedisClusterBuilder nodeLifetimeSecs(final Integer nodeLifetimeSecs) {
        redisClusterConfig.setNodeLifetimeSeconds(nodeLifetimeSecs);
        return this;
    }

    public RedisClusterBuilder maxRedisConnections(final Integer maxRedisConnections) {
        redisClusterConfig.setMaxRedisConnections(maxRedisConnections);
        return this;
    }

    public RedisClusterBuilder connectionTimeout(final Integer connectionTimeout) {
        redisClusterConfig.setConnectionTimeout(connectionTimeout);
        return this;
    }

    public RedisClusterBuilder generalTimeout(final Integer generalTimeout) {
        redisClusterConfig.setGeneralTimeout(generalTimeout);
        return this;
    }

    public RedisClusterBuilder idleTimeout(final Integer idleTimeout) {
        redisClusterConfig.setIdleTimeout(idleTimeout);
        return this;
    }

    public RedisClusterBuilder reconnectionTimeout(final Integer reconnectionTimeout) {
        redisClusterConfig.setReconnectionTimeout(reconnectionTimeout);
        return this;
    }

    public RedisClusterBuilder pingTimeout(final Integer pingTimeout) {
        redisClusterConfig.setPingTimeout(pingTimeout);
        return this;
    }

    public RedisClusterBuilder retryAttempts(final Integer retryAttempts) {
        redisClusterConfig.setRetryAttempts(retryAttempts);
        return this;
    }

    public RedisClusterBuilder retryInterval(final Integer retryInterval) {
        redisClusterConfig.setRetryInterval(retryInterval);
        return this;
    }

    public RedisClusterBuilder shardingBuckets(final Integer shardingBuckets) {
        redisClusterConfig.setShardingBuckets(shardingBuckets);
        return this;
    }

    public RedisClusterBuilder pipelineSteps(List<RedisPipelineStep> pipelineSteps) {
        redisClusterConfig.setPipelineSteps(pipelineSteps);
        return this;
    }

    public RedisClusterBuilder pipelineSteps(RedisPipelineStep... pipelineSteps) {
        redisClusterConfig.setPipelineSteps(Arrays.asList(pipelineSteps));
        return this;
    }

    public RedisClusterBuilder executorService(final ExecutorService executorService) {
        redisClusterConfig.setExecutorService(executorService);
        return this;
    }

    public RedisClusterPeer build() {
        return new RedisClusterPeer(redisClusterConfig);
    }
}
