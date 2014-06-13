package edu.science.biology

/**
 * Pronunciation: http://www.merckmanuals.com/home/resources/pronunciations/index/a.html
 */
enum Dictionary {
    def size = [
            macro          : 'large',
            micro          : 'small',
            'megalo/megaly': 'enlarged']
    def rates = [
            'hyper': 'high/elevated/above',
            'hypo' : 'low/reduced/below',
            'tachy': 'fast/rapid',
            'brady': 'slow/reduced']
    def color = [
            'chloro': 'green',
            'leuk'  : 'white',
            'eryth' : 'red',
            'cyan'  : 'blue']
    def location = [
            'endo/intra': 'inside, within',
            'inter'     : 'between',
            'trans'     : 'across',
            'peri'      : 'around',
            'extra'     : 'outside']
    def testsAndProcedures = [
            echo       : 'using ultrasonic waves',
            electro    : 'using electricity',
            '-ectomy'  : 'removal of',
            '-gram'    : 'picture',
            '-graph(y)': 'process of making an image',
            '-otomy'   : 'making a cut in',
            '-scopy'   : 'using an instrument for viewing',
            '-stomy'   : 'create an opening']
    def problems = [
            'dys-'  : 'now working properly',
            'mal-'  : 'bad, malaria - meant to be meant to spread via air, so = bad air',
            '-emia' : 'blood condition',
            '-itis' : 'inflammation',
            '-osis' : 'condition or disease',
            '-pathy': 'disease']
    def partsOfBody = [
            abdomeno: 'abdomen, peritoneal, belly cavity',
            ACRO    : ['extremety', 'acromegaly - enlarged arms and feet'],
            ADENO   : 'gland, adenoma - a tumor of some gland',
            ANGIO   : ['vessel', 'angiogram - a graph of vasculature'],
            VENO    : ['veins'], PLEBO: ['veins'],
            ARTHRO  : ['joint', 'arthritis - inflamation of joints'],
            CARDIO  : ['heart'],
            CHONDRO : ['cartilage'],
            CYSTO   : ['bladder, sac', 'cystitis - bladder infection'],
            CYTO    : ['cell'],
            DENTO   : ['tooth'],
            DERMATO : ['skin'], DERMO: ['skin'],

            DUODEMO : ['duodenum'],
            STOMATO : ['mouth', 'stomatitis - inflamation inside the mouth'],
            COLO    : ['column, large intenstine'],

            GASTRO  : ['stomach', 'gistritis - inflamation of stomach'],
            HEPATO  : ['liver', 'hepatoma - tumor of the liver, hepatits - infection of liver'],
            LARYNGO : ['larynx, voice box', 'laryngitis - inflamation of of larynx'],
            MYO     : ['muscle'], SARCO: ['muscle'],
            NEPHRO  : ['kidney'],
            NEURO   : ['nerves'],
            OSTEO   : ['bone'],

            OTO     : ['ear'],
            TYMPANO : ['eardrum'],

            PATHO   : ['disease'],
            PNEUMONO: ['lung'],
            RHINO   : ['nose'],
            THORACO : ['thorax, pleural, chest'],
            CEPHALO : ['head'],
            CERVICO : ['neck'],
            AXILARY : ['arm pit']
    ]

}
