package com.cedarsoft.otec;

import org.fest.assertions.Delta;
import org.junit.*;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author Johannes Schneider (<a href="mailto:js@cedarsoft.com">js@cedarsoft.com</a>)
 */
public class SecondHandArticleTest {
  @Test
  public void testIt() throws Exception {
    Article article = new DefaultArticle( "dadescription", new Money( 10099 ) );
    assertThat( article.getDescription() ).isEqualTo( "dadescription" );
    assertThat( article.getValue().asDouble() ).isEqualTo( 100.99 );


    Article secondHandArticle = new SecondHandArticle( article, 0.1 );
    assertThat( secondHandArticle.getDescription() ).isEqualTo( "dadescription (gebraucht)" );
    assertThat( secondHandArticle.getValue().asDouble() ).isEqualTo( 100.99 * 0.9, Delta.delta( 0.005 ) );
  }
}
