import React from 'react';
import './style.css';
import { BoardListItem } from 'types/interface';
import Rectangle24 from '../../assets/ju/emptyImage.png';
import { useNavigate } from 'react-router-dom';

interface Props {
    boardlistItem: BoardListItem
}

// 컴포넌트: BoardList 컴포넌트          //
export default function BoardItem({ boardlistItem }: Props) {
    //          properties          //
    const { boardNumber, title, content, boardTitleImage, favoriteCount, price } = boardlistItem;
    
    //          function:네비게이트 함수          //
    //const navigator = useNavigate();

    //          event handler : 게시물 아이템 클릭 이벤트 처리 함수         //
    const onClickHandler = () => {
        //navigator(boardNumber);
    }

    // ratingToPercent 함수 정의
    const ratingToPercent = () => {
        const score = favoriteCount * 20;
        return score + 1.5;
    };

    // render: BoardListItem 컴포넌트 렌더링
    return (
        <div className='board-list-item'>
            <div className='recipe-card'>
                <div className='recipe-image' style={{ backgroundImage: `url(${Rectangle24})` }}></div>
                
                <div className='favorite-count'>
                    평점:
                    <div className="star-ratings">
                        <div 
                            className="star-ratings-fill space-x-2 text-lg" 
                            style={{ width: `${ratingToPercent()}%` }}
                        >
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                        <div className="star-ratings-base space-x-2 text-lg">
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                    </div>
                </div>

                <div className='price'>
                    약 {price} 냥
                </div>

                <hr className='line' />

                <div className='title'>
                    {title}
                </div>

                <div className='content'>
                    {content}
                </div>
            </div>
        </div>
    );
}