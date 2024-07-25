package com.photon.modules.product.commands.handlers;

import com.photon.common.BaseIT;
import com.photon.core.commandinvoker.CommandRequest;
import com.photon.core.commandinvoker.CommandResponse;
import com.photon.infrastructure.Response;
import com.photon.modules.product.commands.request.SaveProductCommandRequest;
import com.photon.modules.product.entity.Product;
import com.photon.modules.product.repository.ProductRepository;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.Optional;

@SqlGroup({
        //@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:db/product/delete_product.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:db/product/delete_product.sql")
})
public class SaveProductCommandHandlerIT extends BaseIT {

    private ProductRepository productRepository;

    private SaveProductCommandHandler saveProductCommandHandler;

    @BeforeEach
    public void setup() {
        this.saveProductCommandHandler = getBean(SaveProductCommandHandler.class);
        this.productRepository = getBean(ProductRepository.class);
    }

    @Test
    @DisplayName("Test Save Product")
    public void testSaveProduct() {
        //arrange
        final SaveProductCommandRequest saveProductCommandRequest = new SaveProductCommandRequest();
        saveProductCommandRequest.setName("pencil");
        saveProductCommandRequest.setPrice("20.0");
        saveProductCommandRequest.setDescription("buy pencil");

        //act
        saveProductCommandHandler.execute(saveProductCommandRequest);

        //assert
        Optional<Product> productOptional = productRepository.findById(saveProductCommandRequest.getCommandResponse().getId());
        Assertions.assertThat(productOptional.isPresent()).isEqualTo(true);
        Assertions.assertThat(productOptional.get().getName()).isEqualTo("pencil");
        Assertions.assertThat(productOptional.get().getPrice()).isEqualTo("20.0");
    }

}
