/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  The ASF licenses this file to You
* under the Apache License, Version 2.0 (the "License"); you may not
* use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.  For additional information regarding
* copyright in this work, please see the NOTICE file in the top level
* directory of this distribution.
*/
package org.apache.abdera.test.parser.stax;

import junit.framework.TestCase;

import org.apache.abdera.model.Document;
import org.apache.abdera.model.Element;
import org.apache.abdera.parser.Parser;

import java.io.InputStream;
import java.net.URI;

public abstract class BaseParserTestCase extends TestCase {

  protected static <T extends Element>Document<T> parse(URI uri) {
    try {
      String uriStr = uri.toString();
      String path = uriStr.substring(uriStr.indexOf("//") + 1);
      InputStream stream = BaseParserTestCase.class.getResourceAsStream(path);
      return Parser.INSTANCE.parse(stream, uri);
    } catch (Exception e) {}
    return null;
  }

}
