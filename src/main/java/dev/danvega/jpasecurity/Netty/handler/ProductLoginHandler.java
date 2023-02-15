package dev.danvega.jpasecurity.Netty.handler;


import dev.danvega.jpasecurity.ModelDtos.ProductDto;
import dev.danvega.jpasecurity.Service.ProductMap;
import dev.danvega.jpasecurity.model.Product;
import dev.danvega.jpasecurity.repository.ProductRepository;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
@ChannelHandler.Sharable
public class ProductLoginHandler extends ChannelInboundHandlerAdapter {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    Service service;

    ProductDto productDto;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        String Message=msg.toString();
        if(Message.length()>22) {
            if (Message.startsWith("login ")) {
                String macId = service.macFetch(Message);
                Optional<Product> product = productRepository.findByMacId(macId);
                if (product.isPresent()) {
                    productDto = new ProductDto(product.get(), ctx.channel());
                    ProductMap.put(productDto);
                    System.out.println(ProductMap.getProductHashMap().size());
                    ctx.writeAndFlush("successfully logged in");
                }else {
                    ctx.close();
                }
            }
        }else
        {
            ctx.close();
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
