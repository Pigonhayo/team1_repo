import React from 'react';
import './style.css';
import Rectangle23 from '../../assets/images/Rectangle23.png';
import { BoardListItem } from 'types/interface';

interface Props {
    top3ListItem: BoardListItem
}

export default function Top3Item({ top3ListItem }: Props) {

    //          properties          //
    const { boardNumber, title, content, boardTitleImage } = top3ListItem;
    const { favoriteCount, commentCount } = top3ListItem;
    const { writeDateTime, writerNickname } = top3ListItem;

    //          function: 네비게이트 함수          //
    // const navigator = useNavigate();
    
    //          event handler: 게시물 아이템 클릭 이벤트 처리 함수          //
    const onClickHandler = () => {
        // navigator(boardNumber);
    }    

    //          render: Top 3 List Item 컴포넌트 렌더링          //
    return (
        <div className='top-3-list-item'>
            <div className='top-3-list-item-box'>
                <div className='top-3-list-item-box-top'>
                    <div 
                        className='top-3-list-item-image' 
                        style={{ backgroundImage: `url(${boardTitleImage})` }} 
                        onClick={onClickHandler}
                    >
                        {/* <img src={Rectangle23} alt="까르보나라" /> */}
                    </div>
                    <h4 className='top-3-list-item-name'>{'까르보나라dddddddfdfdfdfdfdfdfdfdfdfdfdfd'}</h4>
                </div>
                <div className='top-3-list-item-box-bottom'>
                    <hr className="dotted-line" />
                    <div className='top-3-list-item-content'>{'한 줄 소 개dddddddfdfdfdfdfdfdfdfdfdfdfdfd'}</div>
                </div>
            </div>
        </div>
    )
}