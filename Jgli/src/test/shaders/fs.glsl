#version 450

in vec2 uv;

out vec4 outputColor;

uniform sampler1D _sampler1D;
uniform isampler1D _isampler1D;
uniform usampler1D _usampler1D;

uniform sampler2D _sampler2D;
uniform isampler2D _isampler2D;
uniform usampler2D _usampler2D;

uniform sampler3D _sampler3D;
uniform isampler3D _isampler3D;
uniform usampler3D _usampler3D;

uniform samplerCube _samplerCube;
uniform isamplerCube _isamplerCube;
uniform usamplerCube _usamplerCube;

uniform sampler1DArray _sampler1DArray;
uniform isampler1DArray _isampler1DArray;
uniform usampler1DArray _usampler1DArray;

uniform sampler2DArray _sampler2DArray;
uniform isampler2DArray _isampler2DArray;
uniform usampler2DArray _usampler2DArray;

uniform float lod;
uniform int sampler;
uniform int layer;

void main()
{
    switch(sampler) 
    {
        case 0: outputColor = textureLod(_sampler1D, uv.x, lod);   break;
        case 1: outputColor = textureLod(_isampler1D, uv.x, lod);  break;
        case 2: outputColor = textureLod(_usampler1D, uv.x, lod);  break;

        case 3: outputColor = textureLod(_sampler2D, uv, lod);  break;
        case 4: outputColor = textureLod(_isampler2D, uv, lod); break;
        case 5: outputColor = textureLod(_usampler2D, uv, lod); break;

        case 6: outputColor = textureLod(_sampler3D, vec3(uv, layer), lod); break;
        case 7: outputColor = textureLod(_isampler3D, vec3(uv, layer), lod);break;
        case 8: outputColor = textureLod(_usampler3D, vec3(uv, layer), lod);break;

        case 9: outputColor = textureLod(_samplerCube, vec3(uv, layer), lod);   break;
        case 10:outputColor = textureLod(_isamplerCube, vec3(uv, layer), lod);  break;
        case 11:outputColor = textureLod(_usamplerCube, vec3(uv, layer), lod);  break;

        case 12:outputColor = textureLod(_sampler1DArray, uv, lod);    break;
        case 13:outputColor = textureLod(_isampler1DArray, uv, lod);   break;
        case 14:outputColor = textureLod(_usampler1DArray, uv, lod);   break;

        case 15:outputColor = textureLod(_sampler2DArray, vec3(uv, layer), lod);    break;
        case 16:outputColor = textureLod(_isampler2DArray, vec3(uv, layer), lod);   break;
        case 17:outputColor = textureLod(_usampler2DArray, vec3(uv, layer), lod);   break;
    }
}
