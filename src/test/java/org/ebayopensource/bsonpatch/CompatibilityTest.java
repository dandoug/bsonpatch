/*
 * Original work Copyright 2016 flipkart.com zjsonpatch.
 * Modified work Copyright 2017 ebayopensource.org bsonpatch.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.ebayopensource.bsonpatch;

import static org.ebayopensource.bsonpatch.CompatibilityFlags.MISSING_VALUES_AS_NULLS;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.EnumSet;

import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.junit.Before;
import org.junit.Test;

public class CompatibilityTest {

    BsonArray addNodeWithMissingValue;
    BsonArray replaceNodeWithMissingValue;

    @Before
    public void setUp() throws Exception {
        addNodeWithMissingValue = BsonArray.parse("[{\"op\":\"add\",\"path\":\"a\"}]");
        replaceNodeWithMissingValue = BsonArray.parse("[{\"op\":\"replace\",\"path\":\"a\"}]");
    }

    @Test
    public void withFlagAddShouldTreatMissingValuesAsNulls() throws IOException {
        BsonDocument expected = BsonDocument.parse("{\"a\":null}");
        BsonDocument result = BsonPatch.apply(addNodeWithMissingValue, new BsonDocument(), EnumSet.of(MISSING_VALUES_AS_NULLS)).asDocument();
        assertThat(result, equalTo(expected));
    }

    @Test
    public void withFlagAddNodeWithMissingValueShouldValidateCorrectly() {
        BsonPatch.validate(addNodeWithMissingValue, EnumSet.of(MISSING_VALUES_AS_NULLS));
    }

    @Test
    public void withFlagReplaceShouldTreatMissingValuesAsNull() throws IOException {
    	BsonDocument source = BsonDocument.parse("{\"a\":\"test\"}");
    	BsonDocument expected = BsonDocument.parse("{\"a\":null}");
    	BsonDocument result = BsonPatch.apply(replaceNodeWithMissingValue, source, EnumSet.of(MISSING_VALUES_AS_NULLS)).asDocument();
        assertThat(result, equalTo(expected));
    }

    @Test
    public void withFlagReplaceNodeWithMissingValueShouldValidateCorrectly() {
        BsonPatch.validate(addNodeWithMissingValue, EnumSet.of(MISSING_VALUES_AS_NULLS));
    }
}