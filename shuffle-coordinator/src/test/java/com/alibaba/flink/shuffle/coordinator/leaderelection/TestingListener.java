/*
 * Copyright 2021 Alibaba Group Holding Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.flink.shuffle.coordinator.leaderelection;

import com.alibaba.flink.shuffle.coordinator.highavailability.LeaderInformation;
import com.alibaba.flink.shuffle.coordinator.highavailability.LeaderRetrievalListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test {@link LeaderRetrievalListener} implementation which offers some convenience functions for
 * testing purposes.
 */
public class TestingListener extends TestingRetrievalBase implements LeaderRetrievalListener {

    private static final Logger LOG = LoggerFactory.getLogger(TestingListener.class);

    @Override
    public void notifyLeaderAddress(LeaderInformation leaderInfo) {
        LOG.info("Notified about new leader {}.", leaderInfo);
        offerToLeaderQueue(leaderInfo);
    }

    @Override
    public void handleError(Exception exception) {
        super.handleError(exception);
    }
}
