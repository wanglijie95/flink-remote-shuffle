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

package com.alibaba.flink.shuffle.coordinator.utils;

import com.alibaba.flink.shuffle.common.utils.CommonUtils;
import com.alibaba.flink.shuffle.core.ids.DataSetID;
import com.alibaba.flink.shuffle.core.ids.JobID;
import com.alibaba.flink.shuffle.core.ids.MapPartitionID;

/** Utilities to generate id. */
public class RandomIDUtils {

    public static JobID randomJobId() {
        return new JobID(CommonUtils.randomBytes(16));
    }

    public static DataSetID randomDataSetId() {
        return new DataSetID(CommonUtils.randomBytes(16));
    }

    public static MapPartitionID randomMapPartitionId() {
        return new MapPartitionID(CommonUtils.randomBytes(16));
    }
}
