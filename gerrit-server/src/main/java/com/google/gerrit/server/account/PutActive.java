// Copyright (C) 2013 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.gerrit.server.account;

import com.google.gerrit.common.data.GlobalCapability;
import com.google.gerrit.extensions.annotations.RequiresCapability;
import com.google.gerrit.extensions.restapi.ResourceNotFoundException;
import com.google.gerrit.extensions.restapi.Response;
import com.google.gerrit.extensions.restapi.RestModifyView;
import com.google.gerrit.server.account.PutActive.Input;
import com.google.gwtorm.server.OrmException;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.io.IOException;
import org.eclipse.jgit.errors.ConfigInvalidException;

@RequiresCapability(GlobalCapability.MODIFY_ACCOUNT)
@Singleton
public class PutActive implements RestModifyView<AccountResource, Input> {
  public static class Input {}

  private final SetInactiveFlag setInactiveFlag;

  @Inject
  PutActive(SetInactiveFlag setInactiveFlag) {
    this.setInactiveFlag = setInactiveFlag;
  }

  @Override
  public Response<String> apply(AccountResource rsrc, Input input)
      throws ResourceNotFoundException, OrmException, IOException, ConfigInvalidException {
    return setInactiveFlag.activate(rsrc.getUser());
  }
}
