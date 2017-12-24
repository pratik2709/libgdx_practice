package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.udacity.gamedev.gigagal.entities.GigaGal;
import com.udacity.gamedev.gigagal.entities.Platform;


public class Level {
    GigaGal gigaGal;
    Array<Platform> platformArray;


    public Level(){
        platformArray = new Array<Platform>();
        addDebugPlatform();
    }

    private void addDebugPlatform() {
        platformArray.add(new Platform(15, 100, 30, 20));
        platformArray.add(new Platform(75, 90, 100, 65));
        platformArray.add(new Platform(35, 55, 50, 20));
        platformArray.add(new Platform(10, 20, 20, 9));

        gigaGal = new GigaGal(new Vector2(80, 110));
    }

    public void render(SpriteBatch batch){
        batch.begin();
        for(Platform platform:platformArray){
            platform.render(batch);
        }
        batch.end();
        gigaGal.render(batch);
    }

    public void update(float delta){
        gigaGal.update(delta, platformArray);
    }
}
