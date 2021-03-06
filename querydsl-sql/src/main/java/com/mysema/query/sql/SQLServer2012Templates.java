/*
 * Copyright 2013, Mysema Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mysema.query.sql;

import com.mysema.query.QueryFlag.Position;
import com.mysema.query.QueryMetadata;
import com.mysema.query.QueryModifiers;

/**
 * SQLServer2012Templates is an SQL dialect for Microsoft SQL Server 2012 and later
 *
 * @author tiwe
 *
 */
public class SQLServer2012Templates extends SQLServerTemplates {

    private String limitOffsetTemplate = "\noffset {1} rows fetch next {0} rows only";

    private String offsetTemplate = "\noffset {0} rows";

    public static Builder builder() {
        return new Builder() {
            @Override
            protected SQLTemplates build(char escape, boolean quote) {
                return new SQLServer2012Templates(escape, quote);
            }
        };
    }

    public SQLServer2012Templates() {
        this('\\',false);
    }

    public SQLServer2012Templates(boolean quote) {
        this('\\',quote);
    }

    public SQLServer2012Templates(char escape, boolean quote) {
        super(escape, quote);
    }

    @Override
    public void serialize(QueryMetadata metadata, boolean forCountRow, SQLSerializer context) {
        context.serializeForQuery(metadata, forCountRow);

        if (!metadata.getFlags().isEmpty()) {
            context.serialize(Position.END, metadata.getFlags());
        }
    }

    @Override
    protected void serializeModifiers(QueryMetadata metadata, SQLSerializer context) {
        QueryModifiers mod = metadata.getModifiers();
        if (mod.getLimit() == null) {
            context.handle(offsetTemplate, mod.getOffset());
        } else if (mod.getOffset() == null) {
            context.handle(limitOffsetTemplate, mod.getLimit(), 0);
        } else {
            context.handle(limitOffsetTemplate, mod.getLimit(), mod.getOffset());
        }
    }

}
