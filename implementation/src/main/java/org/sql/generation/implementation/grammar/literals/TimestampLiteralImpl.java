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

package org.sql.generation.implementation.grammar.literals;

import java.sql.Timestamp;

import org.sql.generation.api.common.NullArgumentException;
import org.sql.generation.api.grammar.literals.TimestampTimeLiteral;
import org.sql.generation.implementation.grammar.common.NonBooleanExpressionImpl;
import org.sql.generation.implementation.transformation.spi.SQLProcessorAggregator;

/**
 * 
 * @author Stanislav Muhametsin
 */
public class TimestampLiteralImpl extends NonBooleanExpressionImpl<TimestampTimeLiteral>
    implements TimestampTimeLiteral
{

    private final Timestamp _date;

    public TimestampLiteralImpl( SQLProcessorAggregator processor, Timestamp date )
    {
        this( processor, TimestampTimeLiteral.class, date );
    }

    protected TimestampLiteralImpl( SQLProcessorAggregator processor, Class<? extends TimestampTimeLiteral> implClass,
        Timestamp date )
    {
        super( processor, implClass );

        NullArgumentException.validateNotNull( "Timestamp", date );
        this._date = date;
    }

    public Timestamp getTimestamp()
    {
        return this._date;
    }

    @Override
    protected boolean doesEqual( TimestampTimeLiteral another )
    {
        return this._date.equals( another.getTimestamp() );
    }
}
