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

public class BsonPatchApplicationException extends RuntimeException {
	private static final long serialVersionUID = 7562538769544371424L;

	public BsonPatchApplicationException(String message) {
        super(message);
    }

    public BsonPatchApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public BsonPatchApplicationException(Throwable cause) {
        super(cause);
    }
}