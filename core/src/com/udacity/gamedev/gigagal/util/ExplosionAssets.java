package com.udacity.gamedev.gigagal.util;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class ExplosionAssets {

    Animation<TextureRegion> explosionAnimation;

    public ExplosionAssets(TextureAtlas atlas) {

        Array<TextureAtlas.AtlasRegion> explosionFrames = new Array<TextureAtlas.AtlasRegion>();

        explosionFrames.add(atlas.findRegion(Constants.EXPLOSION_LARGE));
        explosionFrames.add(atlas.findRegion(Constants.EXPLOSION_SMALL));
        explosionFrames.add(atlas.findRegion(Constants.EXPLOSION_MEDIUM));

        explosionAnimation = new Animation<TextureRegion>(Constants.EXPLOSION_DURATION,
                explosionFrames,
                Animation.PlayMode.LOOP);
    }
}