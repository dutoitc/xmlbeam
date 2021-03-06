/**
 *  Copyright 2012 Sven Ewald
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.xmlbeam.tutorial.e03_eclipse;

import java.util.List;

import org.xmlbeam.annotation.XBDocURL;
import org.xmlbeam.annotation.XBRead;

/**
 * We proceed with our examples to parameterized projections. Because
 * projections will be compiled and processed when used, there is no need to
 * keep them static. Instead give your getter method some parameters. They will
 * be applied as a {@lik MessageFormat} on the XBRead expression. (This is
 * possible on XBDocURL annotations, too).
 * 
 * @author <a href="https://github.com/SvenEwald">Sven Ewald</a>
 */
@SuppressWarnings("javadoc")
//START SNIPPET: EclipseCodeFormatterConfig
@XBDocURL("resource://eclipsecodeformatprofile.xml")
public interface EclipseFormatterConfigFile {

    interface Setting {

        @XBRead("@id")
        String getName();

        @XBRead("@value")
        String getValue();
        
    }

    @XBRead("//profile/@name")
    List<String> getProfileNames();

    @XBRead("//profiles/profile[@name=\"{0}\"]/setting")
    List<Setting> getAllSettingsForProfile(String profileName);
    
}
//END SNIPPET: EclipseCodeFormatterConfig