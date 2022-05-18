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

package com.alibaba.flink.shuffle.coordinator.manager.assignmenttracker;

import com.alibaba.flink.shuffle.coordinator.manager.DataPartitionCoordinate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/** Records the assignments of partition. */
public class JobStatus {

    private final Map<DataPartitionCoordinate, WorkerStatus> dataPartitions = new HashMap<>();

    public Map<DataPartitionCoordinate, WorkerStatus> getDataPartitions() {
        return Collections.unmodifiableMap(dataPartitions);
    }

    public void addDataPartition(DataPartitionCoordinate coordinate, WorkerStatus workerStatus) {
        dataPartitions.put(coordinate, workerStatus);
    }

    public void removeDataPartition(DataPartitionCoordinate coordinate) {
        dataPartitions.remove(coordinate);
    }
}
