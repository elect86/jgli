#version 450

in vec2 uv;

out vec4 outputColor;

uniform sampler2D texture0;
uniform isampler2D iTexture0;
uniform usampler2D uTexture0;

uniform float lod;
uniform int sampler;

void main()
{
    switch(sampler) 
    {
        case 0:
            outputColor = textureLod(texture0, uv, lod);
            break;

        case 1:
            outputColor = textureLod(iTexture0, uv, lod);
            break;

        case 2:
            outputColor = textureLod(uTexture0, uv, lod);
            break;
    }
}
