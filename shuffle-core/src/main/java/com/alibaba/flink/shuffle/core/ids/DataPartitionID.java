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

package com.alibaba.flink.shuffle.core.ids;

import com.alibaba.flink.shuffle.core.storage.DataPartition;

/** Base ID of the data partition. */
public abstract class DataPartitionID extends BaseID {

    private static final long serialVersionUID = -3448851707447828689L;

    public DataPartitionID(byte[] id) {
        super(id);
    }

    public abstract DataPartition.DataPartitionType getPartitionType();
}
