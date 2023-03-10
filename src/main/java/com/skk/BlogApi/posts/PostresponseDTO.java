package com.skk.BlogApi.posts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PostresponseDTO {
   private  String title;
   private String Author;
   private String message;

   private Long AthorId;
}
