package com.klezovich.catbot.bot;

import com.klezovich.catbot.photo.CatPhotoProvider;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.component.telegram.model.IncomingMessage;
import org.apache.camel.component.telegram.model.OutgoingPhotoMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Bot {

    private final CatPhotoProvider provider;

    @Autowired
    public Bot(CatPhotoProvider provider) {
        this.provider = provider;
    }

    /**
     * This method processes incoming messages and return responses.
     *
     * @param message a message coming from a human user in a chat
     * @return the reply of the bot. Return null if you don't want to answer
     */
    public OutgoingPhotoMessage process(IncomingMessage message) {
        if (message == null) {
            return null; // skip non-text messages
        }

        log.info("Received message: {}", message);

        return createMessageWithRandomCatPhoto();
    }

    private OutgoingPhotoMessage createMessageWithRandomCatPhoto() {
        var message = new OutgoingPhotoMessage();
        message.setPhoto(provider.getPhotoBytes());
        message.setFilenameWithExtension("cat.png");
        message.setCaption("Here's a cute kitty for you :3");

        return message;
    }
}