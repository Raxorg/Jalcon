package com.epicness.jalcon.game.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import java.util.ArrayList;
import java.util.List;

public class GameAssetPaths {
    static final List<AssetDescriptor<?>> ASSETS;

    public static final AssetDescriptor<Music> MUSICLOBBY_MUSIC;

    public static final AssetDescriptor<Sprite> PLANET1_SPRITE;

    public static final AssetDescriptor<Sprite> PLANET2_SPRITE;

    public static final AssetDescriptor<Sprite> SHIP_SPRITE;

    public static final AssetDescriptor<Sprite> SHIP2_SPRITE;

    public static final AssetDescriptor<Sprite> SHIP3_SPRITE;

    public static final AssetDescriptor<Sprite> STARFIELD_SPRITE;

    public static final AssetDescriptor<ShaderProgram> HORIZONTALBLUR4_SHADER_PROGRAM;

    public static final AssetDescriptor<ShaderProgram> HORIZONTALBLUR8_SHADER_PROGRAM;

    public static final AssetDescriptor<ShaderProgram> VERTICALBLUR4_SHADER_PROGRAM;

    public static final AssetDescriptor<ShaderProgram> VERTICALBLUR8_SHADER_PROGRAM;

    static {
        ASSETS = new ArrayList<>();
        ASSETS.add(MUSICLOBBY_MUSIC = new AssetDescriptor<>("jalcon/game/audio/musicLobby.mogg", Music.class));
        ASSETS.add(PLANET1_SPRITE = new AssetDescriptor<>("jalcon/game/images/planet1.png", Sprite.class));
        ASSETS.add(PLANET2_SPRITE = new AssetDescriptor<>("jalcon/game/images/planet2.png", Sprite.class));
        ASSETS.add(SHIP_SPRITE = new AssetDescriptor<>("jalcon/game/images/ship.png", Sprite.class));
        ASSETS.add(SHIP2_SPRITE = new AssetDescriptor<>("jalcon/game/images/ship2.png", Sprite.class));
        ASSETS.add(SHIP3_SPRITE = new AssetDescriptor<>("jalcon/game/images/ship3.png", Sprite.class));
        ASSETS.add(STARFIELD_SPRITE = new AssetDescriptor<>("jalcon/game/images/starfield.png", Sprite.class));
        ASSETS.add(HORIZONTALBLUR4_SHADER_PROGRAM = new AssetDescriptor<>("jalcon/game/shaders/horizontalBlur4.sp", ShaderProgram.class));
        ASSETS.add(HORIZONTALBLUR8_SHADER_PROGRAM = new AssetDescriptor<>("jalcon/game/shaders/horizontalBlur8.sp", ShaderProgram.class));
        ASSETS.add(VERTICALBLUR4_SHADER_PROGRAM = new AssetDescriptor<>("jalcon/game/shaders/verticalBlur4.sp", ShaderProgram.class));
        ASSETS.add(VERTICALBLUR8_SHADER_PROGRAM = new AssetDescriptor<>("jalcon/game/shaders/verticalBlur8.sp", ShaderProgram.class));
    }
}