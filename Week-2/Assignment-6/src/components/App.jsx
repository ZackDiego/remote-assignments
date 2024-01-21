
import {useState} from 'react';

import Header from './Header';
import ContentBoxArea from './ContentBoxArea';


const App = () =>{
  // Banner Click event
  const [bannerText, setBannerText] = useState("Welcome Message");
  const handleBannerText = () => {
    setBannerText("Have a Good Time!")
  }

  //
  const [showMoreItems, setShowMoreItems] = useState(false);
  const handleShowMore = () => {
    console.log('show more')
    setShowMoreItems( preState => !preState )
  }
  
  
  return (
    <div>
      <Header />
      <div className="banner">
          <h1 onClick={handleBannerText}>{bannerText}</h1>
      </div>
      <section className="main-content">
        <h2>Section title</h2>
        <ContentBoxArea />
        <button className="button" onClick={handleShowMore}>Call to action</button>
      </section>

      {showMoreItems ? (
        <section className="hidden-content main-content">
          <ContentBoxArea />
        </section>
      ) : null}
    </div>
  )
} 

export default App
