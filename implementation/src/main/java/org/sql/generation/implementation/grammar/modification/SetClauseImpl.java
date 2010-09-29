/*
 * Copyright (c) 2010, Stanislav Muhametsin. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.sql.generation.implementation.grammar.modification;

import org.atp.spi.TypeableImpl;
import org.sql.generation.api.common.NullArgumentException;
import org.sql.generation.api.grammar.modification.SetClause;
import org.sql.generation.api.grammar.modification.UpdateSource;

/**
 * 
 * @author Stanislav Muhametsin
 */
public class SetClauseImpl extends TypeableImpl<SetClause, SetClause>
    implements SetClause
{

    private final String _target;

    private final UpdateSource _source;

    public SetClauseImpl( String updateTarget, UpdateSource updateSource )
    {
        this( SetClause.class, updateTarget, updateSource );
    }

    protected SetClauseImpl( Class<? extends SetClause> expressionClass, String updateTarget, UpdateSource updateSource )
    {
        super( expressionClass );
        NullArgumentException.validateNotNull( "update target", updateTarget );
        NullArgumentException.validateNotNull( "source", updateSource );

        this._target = updateTarget;
        this._source = updateSource;
    }

    public UpdateSource getUpdateSource()
    {
        return this._source;
    }

    public String getUpdateTarget()
    {
        return this._target;
    }

    @Override
    protected boolean doesEqual( SetClause another )
    {
        return this._target.equals( another.getUpdateTarget() ) && this._source.equals( another.getUpdateSource() );
    }

}
