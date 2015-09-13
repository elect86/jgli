#version 450

in vec2 uv;

out vec4 outputColor;

uniform sampler2D texture0;

uniform float lod;

void main()
{
    outputColor = textureLod(texture0, uv, lod);
}
