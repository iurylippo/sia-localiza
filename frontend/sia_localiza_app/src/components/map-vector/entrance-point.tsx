'use client'
export function MapEntracePoint() {
  return (
    <svg>
      <g id="pin">
        <path
          id="Vector_218"
          d="M387 696C392.523 696 397 691.523 397 686C397 680.477 392.523 676 387 676C381.477 676 377 680.477 377 686C377 691.523 381.477 696 387 696Z"
          stroke="#FF6347"
        />
        <path
          id="Vector_219"
          d="M387 696C392.523 696 397 691.523 397 686C397 680.477 392.523 676 387 676C381.477 676 377 680.477 377 686C377 691.523 381.477 696 387 696Z"
          fill="#FF6347"
        />

        <animate
          attributeName="opacity"
          from="1"
          to="0.3"
          dur="1.1s"
          begin="0s"
          repeatCount="indefinite"
        />
      </g>
    </svg>
  )
}
