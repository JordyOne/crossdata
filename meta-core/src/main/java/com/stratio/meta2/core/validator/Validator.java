/*
 * Licensed to STRATIO (C) under one or more contributor license agreements.
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.  The STRATIO (C) licenses this file
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

package com.stratio.meta2.core.validator;

import java.util.List;

import com.stratio.meta.common.exceptions.IgnoreQueryException;
import com.stratio.meta.common.exceptions.validation.ExistNameException;
import com.stratio.meta.common.exceptions.validation.NotExistNameException;
import com.stratio.meta2.common.data.Name;
import com.stratio.meta2.core.metadata.MetadataManager;
import com.stratio.meta2.core.query.ParsedQuery;
import com.stratio.meta2.core.query.ValidatedQuery;
import org.apache.log4j.Logger;


public class Validator {
  /**
   * Class logger.
   */
  private static final Logger LOG = Logger.getLogger(Validator.class);

  public ValidatedQuery validate(ParsedQuery parsedQuery){
    return null;
  }




  private void validateExist(List<? extends Name> names, boolean hasIfExists)
      throws IgnoreQueryException, NotExistNameException {
    for(Name name:names){
      this.validateExist(name, hasIfExists);
    }
  }



  private void validateExist(Name name, boolean hasIfExists)
      throws NotExistNameException, IgnoreQueryException {
    if(!MetadataManager.MANAGER.exists(name)){
      if(hasIfExists) {
        throw new IgnoreQueryException("["+ name + "] doesn't exist");
      }else{
        throw new NotExistNameException(name);
      }
    }
  }

  private void validateNotExist(List<? extends Name> names, boolean hasIfNotExist)
      throws ExistNameException, IgnoreQueryException {
    for(Name name:names){
      this.validateNotExistCatalog(name,hasIfNotExist);
    }
  }


  private void validateNotExistCatalog(Name name, boolean onlyIfNotExist)
      throws ExistNameException, IgnoreQueryException {
    if(MetadataManager.MANAGER.exists(name)){
      if(onlyIfNotExist) {
        throw new IgnoreQueryException("["+ name + "] exists");
      }else{
        throw new ExistNameException(name);
      }
    }
  }

}
