package com.epicness.fundamentals.stuff;

import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class Shader {

    private ShaderProgram shaderProgram;

    public Shader(ShaderProgram shaderProgram) {
        this.shaderProgram = shaderProgram;
    }

    public ShaderProgram getShaderProgram() {
        return shaderProgram;
    }

    public void setShaderProgram(ShaderProgram shaderProgram) {
        this.shaderProgram = shaderProgram;
    }

    public void bind() {
        shaderProgram.bind();
    }

    public void setUniformF(String name, float value) {
        shaderProgram.setUniformf(name, value);
    }

    public void setUniformF(String name, float value1, float value2) {
        shaderProgram.setUniformf(name, value1, value2);
    }
}