#version 400

in vec2 uv;

out vec4 outputColor;

uniform sampler2D texture0;

void main()
{
    outputColor = texture(texture0, uv).rgba;
}
