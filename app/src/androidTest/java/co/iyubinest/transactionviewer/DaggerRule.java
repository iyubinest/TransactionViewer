/**
 * Copyright (C) 2017 Cristian Gomez Open Source Project
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
package co.iyubinest.transactionviewer;

import android.support.test.InstrumentationRegistry;
import it.cosenonjaviste.daggermock.DaggerMockRule;

public class DaggerRule extends DaggerMockRule<AppComponent> {

  public DaggerRule() {
    super(AppComponent.class, new AppModule(app()));
    set(component -> {
      App app = (App) InstrumentationRegistry.getInstrumentation()
        .getTargetContext()
        .getApplicationContext();
      app.setComponent(component);
    });
  }

  private static App app() {
    return (App) InstrumentationRegistry.getInstrumentation()
      .getTargetContext()
      .getApplicationContext();
  }
}
