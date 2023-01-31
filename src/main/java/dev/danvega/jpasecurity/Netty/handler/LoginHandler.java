/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.danvega.jpasecurity.Netty.handler;


import dev.danvega.jpasecurity.Domain.ChannelRepository;
import dev.danvega.jpasecurity.Domain.use;
import dev.danvega.jpasecurity.model.Product;
import dev.danvega.jpasecurity.repository.ProductRepository;
import io.netty.channel.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


/**
 * event handler to login
 *
 * @author Jibeom Jung akka. Manty
 */
@Component
@Slf4j
@RequiredArgsConstructor
@ChannelHandler.Sharable
public class LoginHandler extends ChannelInboundHandlerAdapter {
    private final ChannelRepository channelRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Service service;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        String message=msg.toString();
        if(!(msg instanceof String))
        {
            ctx.fireChannelRead(msg);
            return;
        } else if(message.startsWith("login "))
        {
            if (log.isDebugEnabled()) {
                log.debug(message);
            }
            use user = use.of(message, ctx.channel());
            user.login(channelRepository, ctx.channel());
            ctx.writeAndFlush("Successfully logged in as " + user.getUsername() + ". \r\n");
        }else if(message.startsWith("register "))
        {
            String[] macIdAndName=service.macAndNameFetch(message);
            Optional<Product> prd=productRepository.findByMacId(macIdAndName[0]);
            if(prd.isPresent())
            {
                ctx.writeAndFlush("Mac address already exists " + macIdAndName[0] + ". \r\n");
            }else
            {
            Product product=new Product();
            product.setMacId(macIdAndName[0]);
            product.setName(macIdAndName[1]);
            productRepository.save(product);
            ctx.writeAndFlush("product has been registered successfully! " + macIdAndName[0] + " \r\n");
            }
        }else
        {
            ctx.fireChannelRead(msg);
            return;
        }
    }
}
