import { Pipe, PipeTransform } from '@angular/core'

@Pipe({
    name: 'title'
})
export class TitlePipe implements PipeTransform{
    transform(name: string, gender: string): string {
        if(gender === 'Male')    {
            return 'Mr. ' + name
        }
        else    {
            return 'Mrs. ' + name
        }
    }
}