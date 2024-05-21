        #include <stdio.h>
        #include <stdlib.h>

        struct cel {
            int conteudo;
            struct cel *seg; // seguinte
        };
        typedef struct cel celula;

        void insere(celula **inicio, celula **fim, int x) {
            celula *novo = malloc(sizeof(celula));
            novo->conteudo = x;
            novo->seg = NULL;
            if (*inicio == NULL) {
                *inicio = novo;
                *fim = novo;
            } else{
                (*fim)->seg = novo;
                *fim = novo;
            }
        }
            

        int remove_celula (celula **inicio, celula **fim){
                celula *lixo;
                lixo = *inicio;
                int cont = lixo->conteudo;
                if(*inicio == *fim){
                    *inicio = NULL;
                    *fim = NULL;
                }else{
                    *inicio = (*inicio)->seg;
                    lixo = NULL;
                }
                free(lixo);
                return cont;
        }

        void main() {
            celula *inicio;
            inicio = NULL;
            celula *fim;
            fim = NULL;

            for (int i = 0; i < 10; i++) {
                insere(&inicio, &fim, i);
            }
            for(int i = 0; i < 10; i++){
                int x = remove_celula(&inicio,&fim);
                printf("A pessoa com o número %d saiu da fila",x);
                printf("\n");
            }

            insere(&inicio,&fim,30);
            int num = inicio->conteudo;
            printf("\nA pessoa número %d entrou na fila.",num);
        }