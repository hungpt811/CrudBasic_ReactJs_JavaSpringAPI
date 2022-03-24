import React from 'react'
import Button from '@atlaskit/button'
import styled from 'styled-components'
import EditFilledIcon from '@atlaskit/icon/glyph/edit-filled';
import TrashIcon from '@atlaskit/icon/glyph/trash';

const ButtonStyled = styled(Button)`
    margin-top: 5px;
    text-align: left;
`;
export default function Todo({employee, onDeleteEmployee}) {
  return <ButtonStyled shouldFitContainer 
    iconAfter={
        <span onClick={() => onDeleteEmployee(employee.id)} className="remove-icon">
          <TrashIcon primaryColor="#F33737"/>
        </span>

    }
    
  >{employee.name}</ButtonStyled>
}
