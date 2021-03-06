/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *  
 *   http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.ebay.bsonpatch;

import java.util.Arrays;
import java.util.EnumSet;

public enum DiffFlags {
    OMIT_VALUE_ON_REMOVE,
    OMIT_MOVE_OPERATION, //only have ADD, REMOVE, REPLACE, COPY Don't normalize operations into MOVE
    OMIT_COPY_OPERATION; //only have ADD, REMOVE, REPLACE, MOVE, Don't normalize operations into COPY

    public static EnumSet<DiffFlags> defaults() {
        return EnumSet.of(OMIT_VALUE_ON_REMOVE);
    }

    public static EnumSet<DiffFlags> dontNormalizeOpIntoMoveAndCopy() {
        return EnumSet.copyOf(Arrays.asList(OMIT_MOVE_OPERATION, OMIT_COPY_OPERATION));
    }
    
}
