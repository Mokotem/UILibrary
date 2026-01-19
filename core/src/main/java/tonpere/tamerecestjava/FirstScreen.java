package tonpere.tamerecestjava;

import com.badlogic.gdx.Screen;

/** First screen of the application. Displayed after the application is created. */
public class FirstScreen implements Screen {
    @Override
    public void show() {
        // Prepare your screen here.
    }

    private void Update()
    {

    }

    @Override
    public void render(float delta) {
        this.Update();
    }

    @Override
    public void resize(int width, int height) {
        if(width <= 0 || height <= 0) return;
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
    }
}