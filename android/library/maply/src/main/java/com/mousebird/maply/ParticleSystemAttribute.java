/*
 *  ParticleSystemAttribute.java
 *  WhirlyGlobeLib
 *
 *  Created by jmnavarro
 *  Copyright 2011-2015 mousebird consulting
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.mousebird.maply;

/**
 * Particle System Attributes are just a name and a data type.  This is a convenient way
 * to pass that information around.
 */
public class ParticleSystemAttribute {

    /**
     * The attribute type the shader will be expecting.
     */
    public enum MaplyShaderAttrType {
        MAPLY_SHADER_ATTR_TYPE_FLOAT4(0),
        MAPLY_SHADER_ATTR_TYPE_FLOAT3(1),
        MAPLY_SHADER_ATTR_TYPE_CHAR4(2),
        MAPLY_SHADER_ATTR_TYPE_FLOAT2(3),
        MAPLY_SHADER_ATTR_TYPE_FLOAT(4),
        MAPLY_SHADER_ATTR_TYPE_INT(5);

        private final int value;

        MaplyShaderAttrType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

    }

    long ident = Identifiable.genID();

    private String name;

    private MaplyShaderAttrType type;

    /**
     * The shader attribute type as defined.  This is what the shader is expecting.
     */
    public MaplyShaderAttrType getType() {
        return type;
    }

    /**
     * The shader attribute type as defined.  This is what the shader is expecting.
     */
    public void setType(MaplyShaderAttrType type) {
        this.type = type;
    }

    /**
     * Name of the attribute.
     */
    public String getName() {
        return name;
    }

    /**
     * Name of the attribute.
     */
    public void setName(String name) {
        this.name = name;
    }

    public long getIdent() {
        return ident;
    }

    public void setIdent(long ident) {
        this.ident = ident;
    }

    /**
     * Calculate the number of bytes for a given attribute type.
     */
    public int getSize()
    {
        int size = 0;
        switch (type){
            case MAPLY_SHADER_ATTR_TYPE_CHAR4:
                size = 4;
                break;
            case MAPLY_SHADER_ATTR_TYPE_INT:
                size = 4;
                break;
            case MAPLY_SHADER_ATTR_TYPE_FLOAT:
                size = 4;
                break;
            case MAPLY_SHADER_ATTR_TYPE_FLOAT2:
                size = 2*4;
                break;
            case MAPLY_SHADER_ATTR_TYPE_FLOAT3:
                size = 3*4;
                break;
            case MAPLY_SHADER_ATTR_TYPE_FLOAT4:
                size = 4*4;
                break;
            default:
                size = 0;
                break;
        }
        return size;
    }
}
