#!/usr/bin/env bash
################################################################################
# Copyright 2021 Alibaba Group Holding Limited.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
################################################################################
# Start/stop a rss shufflemanager.
USAGE="Usage: shufflemanager.sh (start|start-foreground)|stop|stop-all [args]"
ARGS=("${@:2}") # get remaining arguments as array
STARTSTOP=$1

if [[ $STARTSTOP != "start" ]] && [[ $STARTSTOP != "start-foreground" ]] && [[ $STARTSTOP != "stop" ]] && [[ $STARTSTOP != "stop-all" ]]; then
  echo $USAGE
  exit 1
fi

bin=`dirname "$0"`
bin=`cd "$bin"; pwd`

. "$bin"/config.sh

ENTRYPOINT=shufflemanager

if [[ $STARTSTOP == "start" ]] || [[ $STARTSTOP == "start-foreground" ]]; then
    export LOG_PREFIX=${SHUFFLE_LOG_DIR}"/shufflemanager"
    parseShuffleManagerJvmArgsAndExportLogs "${ARGS[@]}"
fi

if [[ $STARTSTOP == "start-foreground" ]]; then
    exec "${SHUFFLE_BIN_DIR}"/shuffle-console.sh $ENTRYPOINT "${ARGS[@]}"
else
    "${SHUFFLE_BIN_DIR}"/shuffle-daemon.sh $STARTSTOP $ENTRYPOINT "${ARGS[@]}"
fi
