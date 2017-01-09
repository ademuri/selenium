// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.openqa.selenium.interactions.internal;

import com.google.common.base.Preconditions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.IsInteraction;
import org.openqa.selenium.internal.Locatable;

/**
 * Base class for all actions.
 */
public abstract class BaseAction implements IsInteraction {
  protected final Locatable where;

  /**
   * Common c'tor - a locatable element is provided.
   *
   * @param actionLocation provider of coordinates for the action.
   */
  protected BaseAction(Locatable actionLocation) {
    this.where = actionLocation;
  }

  protected WebElement getTargetElement() {
    Preconditions.checkNotNull(where, "Unable to determine where to move to");
    Preconditions.checkState(where.getCoordinates().getAuxiliary() instanceof WebElement, "Unable to find element to use: %s", where.getCoordinates());
    return (WebElement) where.getCoordinates().getAuxiliary();
  }
}
