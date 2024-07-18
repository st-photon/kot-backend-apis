package com.photon.modules.product.commands.request;

import com.photon.core.commandinvoker.CommandRequest;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SaveProductCommandRequest extends CommandRequest {

    private String name;

    private String price;

    private String description;

    @Override
    public String toString() {
        return "SaveProductCommandRequest{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
