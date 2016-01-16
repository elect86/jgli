#version 450

in vec3 position;
in vec2 inUV;

out vec2 uv;

uniform mat4 modelToClipMatrix;

void main()
{
    gl_Position = modelToClipMatrix * vec4(position, 1);
   
    uv = inUV;
}